/**
 * Created by VMakarenko on 2/7/15.
 */

angular.module("app").
    controller("CategoryReferenceEditController", function ($scope, CategoryReferenceService) {
        $scope.getAll = function()
        {
            CategoryReferenceService.getAll().success(function (data) {
                $scope.categoryList = data.data;
            });
        };


        $scope.openAddEditCategoryModal = function(id){
            if(id === undefined){
                $scope.currentCategory = {};
            } else {
                $scope.currentCategory = $scope.categoryList[id];
            }
            $('#category-modal').modal();
            $scope.getAll();
        };

        $scope.saveCategory = function(id){
            var action;
            if(id === undefined){
                action = CategoryReferenceService.insert;
            }else{
                action = CategoryReferenceService.update;
            }
            action($scope.currentCategory).success(function(){
                $('#category-modal').modal('hide');
                $scope.getAll();
            });
        };

        $scope.deleteCategoryItem = function(id){
            CategoryReferenceService.delete($scope.categoryList[id].id).success(function(){
                $scope.getAll();
            });
        };

        $scope.getAll();
    });