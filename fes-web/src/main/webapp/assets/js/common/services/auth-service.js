/**
 * Created by VMakarenko on 2/7/15.
 */

angular.module("app")
    .service("AuthService", ['$http',
        function ExtInvestigationRequestsService($http) {
            var url = "api/auth";

            this.register = function (user) {
                return $http.post(url + "/register", user);
            };


            this.login = function (email, password) {
                return $http.post(url + "/login",{email: email, password : password});
            };


            this.logout = function () {
                return $http.post(url + "/logout");
            };


            this.getCurrentUser = function () {
                return $http.get(url + "/getCurrentUser");
            };

            this.isAuthenticated = function () {
                return $http.get(url + '/isAuthenticated');
            };

        }
    ]);

