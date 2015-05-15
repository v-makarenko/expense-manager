/**
 * Created by VMakarenko on 2/7/15.
 */

angular.module('app', [
        'ngRoute','myFilters', 'chart.js', 'ui.bootstrap'
    ]).config(['$routeProvider',
        function ($routeProvider) {
            $routeProvider.
                when('/list', {
                    templateUrl: 'assets/html/expenses/expenses-list.html',
                    controller: 'ExpensesListController',
                    requiresLogin: true
                }).
                when('/print/:dateFrom/:dateTo', {
                    templateUrl: 'assets/html/expenses/print-list.html',
                    controller: 'PrintController',
                    requiresLogin: true
                }).
                when('/analytics', {
                    templateUrl: 'assets/html/expenses/analytics.html',
                    controller: 'AnalyticsController',
                    requiresLogin: true
                }).
                when('/references/:referenceName', {
                    templateUrl: 'assets/html/expenses/reference-edit.html',
                    controller: 'ReferenceEditController',
                    requiresLogin: true
                }).

                otherwise({
                    redirectTo: '/list'
                });
        }])
    .run(function ($rootScope, $location, AuthService) {
        AuthService.isAuthenticated().success(function (result) {

            $rootScope.authenticated = result.status == 'OK';

            var callback = function() {
                if (!$rootScope.authenticated) {
                    location.replace('/fes/index.jsp');
                }
            }

            $rootScope.$on('$routeChangeStart', function (event, next, current) {
                callback();
            });

            callback();

        });
    });

/*.factory('authFactory', ['$rootScope', '$http', function ($rootScope, $http) {

 var authFactory = {
 authData: undefined
 };

 authFactory.login = function (user) {
 return $http.post('http://localhost:8080/expenses/api/auth/', user);
 };

 return authFactory;
 }])
 .controller('LoginCtrl', ['$scope', 'authFactory', function LoginCtrl($scope, authFactory) {
 $scope.login = function (user) {
 authFactory.login(user).success(function (data) {
 authFactory.setAuthData(data);
 // Redirect etc.
 }).error(function () {
 // Error handling
 });*/
//    };
//}])


//;