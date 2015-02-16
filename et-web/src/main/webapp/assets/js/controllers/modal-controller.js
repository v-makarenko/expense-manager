/**
 * Created by VMakarenko on 2/7/15.
 */

angular.module("app").
    controller("ModalController", function($scope, $rootScope){
        $rootScope.$on('modal-reset', function(){
            $scope.myForm.$setPristine();
        });
    });