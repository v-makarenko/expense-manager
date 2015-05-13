/**
 * Created by VMakarenko on 2/7/15.
 */

angular.module("app").
    controller("RegistrationController", function($scope, $location, UserService, AuthService){
        // const
        const EMAIL_REGEX = /\S+@\S+\.\S+/;

        // init
        $scope.newUser = {};
        $scope.loginError = '';
        $scope.passError = '';
        $scope.emailError = '';


        $scope.$watch('newUser.username+newUser.password+newUser.password2+newUser.email',function(newValue, oldValue){
            if($scope.newUser.password !== $scope.newUser.password2){
                $scope.passError = 'Пароли не совпадают';
            }else{
                $scope.passError = undefined;
            }
            if($scope.newUser.email && !EMAIL_REGEX.test($scope.newUser.email)){
                $scope.emailError = 'Некорректный email';
            }else{
                $scope.emailError = undefined;
            }
        });

        $scope.register = function () {
            AuthService.register($scope.newUser).success(function (result){
                $("#registration-modal").modal("hide");
            });
        }



    });