/**
 * Created by VMakarenko on 2/7/15.
 */

angular.module('app', [
        'ngRoute','myFilters', 'chart.js'
    ]).config(['$routeProvider',
        function ($routeProvider) {
            $routeProvider.
                when('/main', {
                    templateUrl: 'assets/html/landing/main-page.html',
                    controller: 'MainPageController'
                }).
                otherwise({
                    redirectTo: '/main'
                });
        }])
    .run(function ($rootScope, $location, AuthService) {
        AuthService.isAuthenticated().success(function (result) {

            $rootScope.authenticated = result.status == 'OK';

            var callback = function() {
                if ($location.url() != 'main' && !$rootScope.authenticated) {
                    $location.path('/main');
                }
            }

            $rootScope.$on('$routeChangeStart', function (event, next, current) {
                callback();
            });

            callback();

        });
    });
