/**
 * Created by VMakarenko on 2/7/15.
 */

angular.module("app").
    controller("ChartController", function ($scope, $rootScope, $location, ExpensesService, AuthService) {
        // const
        const PERIOD_DAY = 0;
        const PERIOD_WEEK = 1;
        const PERIOD_MONTH = 2;
        const PERIOD_YEAR = 3;

        // get date and stuff
        var moment = moment.now();
        var daysInMonth = moment.daysInMonth();

        // initialization
        $scope.chartParams = [
            // days
            {
                labels: _.map(new Array(24), function(item, id){
                    return '' + id + ':00';
                })
            },
            // week
            {
                labels: moment.weekdays()
            },
            // month
            {
                labels: _.map(new Array(Math.ceil(daysInMonth * 1. / 7)), function(item){
                    return '' + item;
                })
            },
            //year
            {
                labels: moment.months()
            }


        ]


        // watches
        $rootScope.watch('periodId', function(oldValue, newValue){
            if(oldValue != newValue){
                $scope.labels = chartParams[newValue].labels;
            }
        });

        $scope.periodId = PERIOD_YEAR;

    });