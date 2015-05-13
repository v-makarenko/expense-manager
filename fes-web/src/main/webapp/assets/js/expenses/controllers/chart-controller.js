/**
 * Created by VMakarenko on 2/7/15.
 */

angular.module("app").
    controller("ChartController", function ($scope, $rootScope, $location, ChartService) {
        // const
        const PERIOD_DAY = 0;
        const PERIOD_WEEK = 1;
        const PERIOD_MONTH = 2;
        const PERIOD_YEAR = 3;
        $scope.options = [
            {
                id: PERIOD_DAY,
                text:'day'
            },
            {
                id: PERIOD_WEEK,
                text:'week'
            },
            {
                id: PERIOD_MONTH,
                text:'month'
            },
            {
                id: PERIOD_YEAR,
                text:'year'
            }]

        // get date and stuff
        var curMoment = moment();
        var daysInMonth = curMoment.daysInMonth();

        // initialization
        $scope.chartParams = [
            // days
            {
                labels: _.map(new Array(24), function(item, id){
                    return id.toString() + ':00';
                })
            },
            // week
            {
                labels: moment.weekdays()
            },
            // month
            {
                labels: _.map(new Array(daysInMonth), function(item,id){
                    return (id+1).toString();
                })
            },
            //year
            {
                labels: moment.months()
            }


        ];

        $scope.chartData =[];


        // btn fns
        $scope.toExcel = function() {

        }

        // watches
        $scope.$watch('periodId', function(newValue, oldValue){
            if(oldValue != newValue){
                $scope.labels = $scope.chartParams[newValue].labels;
                $scope.series = ['Expenses']
                ChartService.getData($scope.periodId).success(function(result){
                    $scope.chartData = [result];
                });
            }
        });


        $scope.periodId = PERIOD_DAY;
    });