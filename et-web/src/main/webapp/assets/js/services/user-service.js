/**
 * Created by VMakarenko on 2/7/15.
 */

angular.module("app")
    .service("UserService", ['$http',
        function UserService($http) {
            var url = "api/user";

            this.checkUsername = function (username) {
                return $http.get(url + "/checkUsername?username=" + username );
            };

            this.createUser = function (user) {
                return $http.post(url, user );
            };


        }
    ]);

