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


        $scope.$watch('newUser.username+newUser.password+newUser.password2+newUser.eMail',function(newValue, oldValue){
            UserService.checkUsername($scope.newUser.username).success(function (result) {
                $scope.loginError = result.ok ? undefined : result.msg;
            });
            if($scope.newUser.password !== $scope.newUser.password2){
                $scope.passError = 'Passwords are different';
            }else{
                $scope.passError = undefined;
            }
            if($scope.newUser.eMail && !EMAIL_REGEX.test($scope.newUser.eMail)){
                $scope.emailError = 'Invalid email';
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