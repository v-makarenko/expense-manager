/**
 * Created by VMakarenko on 2/7/15.
 */

angular.module("app").
    controller("AccountReferenceEditController", function ($scope, AccountReferenceService) {
        $scope.getAll = function()
        {
            AccountReferenceService.getAll().success(function (data) {
                $scope.accountList = data.data;
            });
        };


        $scope.openAddEditAccountModal = function(id){
            if(id === undefined){
                $scope.currentAccount = {};
            } else {
                $scope.currentAccount = $scope.accountList[id];
            }
            $('#account-modal').modal();
            $scope.getAll();
        };

        $scope.saveAccount = function(id){
            var action;
            if(id === undefined){
                action = AccountReferenceService.insert;
            }else{
                action = AccountReferenceService.update;
            }
            action($scope.currentAccount).success(function(){
                $('#account-modal').modal('hide');
                $scope.getAll();
            });
        };

        $scope.deleteAccountItem = function(id){
            AccountReferenceService.delete($scope.accountList[id].id);
            $scope.getAll();
        };

        $scope.getAll();

    });