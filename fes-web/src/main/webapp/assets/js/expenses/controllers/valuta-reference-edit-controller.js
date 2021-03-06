/**
 * Created by VMakarenko on 2/7/15.
 */

angular.module("app").
    controller("ValutaReferenceEditController", function ($scope, ValutaReferenceService) {
        $scope.getAll = function()
        {
            ValutaReferenceService.getAll().success(function (data) {
                $scope.valutaList = data.data;
            });
        };


        $scope.openAddEditValutaModal = function(id){
            if(id === undefined){
                $scope.currentValuta = {};
            } else {
                $scope.currentValuta = $scope.valutaList[id];
            }
            $('#valuta-modal').modal();
            $scope.getAll();
        };

        $scope.saveValuta = function(id){
            var action;
            if(id === undefined){
                action = ValutaReferenceService.insert;
            }else{
                action = ValutaReferenceService.update;
            }
            action($scope.currentValuta).success(function(){
                $('#valuta-modal').modal('hide');
                $scope.getAll();
            });
        };

        $scope.deleteValutaItem = function(id){
            ValutaReferenceService.delete($scope.valutaList[id].id);
            $scope.getAll();
        };

        $scope.getAll();

    });