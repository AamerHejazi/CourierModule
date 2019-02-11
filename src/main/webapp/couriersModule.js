"use strict";

var app = angular.module('couriersModule', ['ngRoute']);

app.config(['$routeProvider', '$locationProvider', function ($routeProvider, $locationProvider) {

    $routeProvider

        .when('/', {
            templateUrl: 'homePage.html'
        })
        .when('/newCourier/:organizationId', { //TODO

            templateUrl: 'createCourier.html',
            controller: 'createCouriers',
            caseInsensitiveMatch: true
        })
        .when('/couriersList', {

            templateUrl: 'couriersList.html',
            controller: 'couriersList'
        })
        .when('/editCourier/:id', {

            templateUrl: 'editCourier.html',
            controller: 'editCourier'
        })
        .when('/home', {

            templateUrl: 'homePage.html',
            controller: 'homeController'
        })
        .otherwise({
            template: '<strong>No Content Available Here..... click one of the links left panel</strong>'
        });

    $locationProvider.hashPrefix('');
    /*$locationProvider.html5Mode({
    enabled: true,
    requireBase: false
    });*/

}]);


app.controller('couriersList', ['$scope', '$filter', 'remoteService', '$location', '$interpolate', '$route', function ($scope, $filter, remoteService, $location, $interpolate, $route) {

    remoteService.listOrganizations().then(function (response) {
        $scope.organizations = response.data;
        $scope.organizations.unshift({organizationId:null, nameAr:"جميع المراسلين"});
        console.log($scope.organizations);
    });


   /* remoteService.listCouriers().then(function (response) {
        $scope.couriers = response.data;
        console.log($scope.couriers);
    });*/

    $scope.specificOrganizationCouriers = function(id){
        remoteService.listCouriers(id).then(function (response) {
            $scope.couriers = response.data;
        });
    };

    $scope.editOneCourier = function (courier) {
        $location.path($interpolate('/editCourier/' + courier.courierId)($scope));
    };

    $scope.enable = function (courier) {
        remoteService.enableCourier(courier.courierId).then(function (response) {
            console.log("the response = " + response.status);
            courier.active = true;
        })
    };

    $scope.disable = function (courier) {
        remoteService.disableCourier(courier.courierId).then(function (response) {
            console.log("the response = " + response.status);
            courier.active = false;
        })
    };

    $scope.removeOneCourier = function (courier) {
        console.log(id);
        remoteService.removeCourier(courier.courierId).then(function (response) {
            console.log("Delete is success = " + response);
            //$route.reload();
        });
    };

    $scope.createCourier = function (organizationId) {
        $location.path($interpolate('/newCourier/'+ organizationId)($scope));
    };

}]);

app.controller('createCouriers', ['$scope', 'remoteService', '$location', '$interpolate', '$routeParams', function ($scope, remoteService, $location, $interpolate, $routeParams) {

    $scope.courier = {};
    $scope.courier.organizationId = parseInt($routeParams.organizationId, 10);
    $scope.cancel = function () {
        $location.path($interpolate('/couriersList')($scope));
    };

    $scope.listallCouriers = function () {
        $location.path($interpolate('/couriersList')($scope));
    };

    $scope.save = function () {
        remoteService.addCourier($scope.courier).then(function () {
            console.log("add item success" + $scope.courier);
            $location.path($interpolate('/couriersList')($scope));
        });
    };
}]);


app.controller('editCourier', ['$scope', '$routeParams', 'remoteService', '$location', '$interpolate', function ($scope, $routeParams, remoteService, $location, $interpolate) {

    remoteService.getCourier($routeParams.id).then(function (response) {

        $scope.courier = response.data;
    });

    $scope.cancel = function () {
        $location.path($interpolate('/couriersList')($scope));
    };


    $scope.saveItem = function () {

        remoteService.updateCourier($scope.courier, $scope.courier.courierId).then(function () {
            $location.path($interpolate('/couriersList')($scope));
        });
    };
}]);


app.service('remoteService', ['$http', function ($http) {

    this.listOrganizations = function () {
      return $http.get('/naqel/app/cts/organizations')
    };

    this.listCouriers = function (organizationId) {
        if(organizationId == null){
            return $http.get('/naqel/app/cts/couriers');
        }
        else {
            return $http.get('/naqel/app/cts/couriers/organization?organizationId=' + organizationId);
        }
    };

    this.addCourier = function (courier) {
        return $http.post('/naqel/app/cts/couriers', courier);
    };

    this.enableCourier = function (id) {
        return $http.put('/naqel/app/cts/couriers/' + id + '/enable');
    };

    this.disableCourier = function (id) {
        return $http.put('/naqel/app/cts/couriers/' + id + '/disable');
    };

    this.removeCourier = function (id) {
        return $http.delete('/naqel/app/cts/couriers/' + id);
    };
    
    this.getCourier = function (id) {
        return $http.get('/naqel/app/cts/couriers/' + id +'/courier');
    };

    this.updateCourier = function (courier, id) {
        return $http.put('/naqel/app/cts/couriers/' + id, courier);
    };

}]);