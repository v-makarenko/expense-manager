/**
 * Created by VMakarenko on 2/7/15.
 */

angular.module("app").
    controller("LoginController", function ($scope, $rootScope, $location, AuthService) {

        $scope.user = {}

        $scope.$watch('user.username+user.password',function(newValue, oldValue){
            $scope.error = undefined;
        });


        //service calls
        $scope.login = function () {
            AuthService.login($scope.user.username, $scope.user.password).success(function (result) {
                if (result.status == 'OK') {
                    $rootScope.authenticated = true;
                    location.replace("/fes/expenses.jsp");
                }else{
                    $scope.error = "Login or password is incorrect";
                }
            });
        };


    });