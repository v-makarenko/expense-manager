/**
 * Created by VMakarenko on 2/7/15.
 */

angular.module("app").
    controller("AccountReferenceEditController", function ($scope, AccountReferenceService) {
        $scope.getAll = function()
        {
            AccountReferenceService.getAll().success(function (data) {
                $scope.accountCategories = data.data;
            });
        };



        $scope.getAll();

    });