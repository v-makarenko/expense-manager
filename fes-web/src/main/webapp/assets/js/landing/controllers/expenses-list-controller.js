/**
 * Created by VMakarenko on 2/7/15.
 */

angular.module("app").
    controller("ExpensesListController", function ($scope, $rootScope, $location, ExpensesService, AuthService) {
        // const
        const NUMBER_REGEX = /^\d+$/;
        const TIME_REGEX = /^\d{2}:\d{2}$/;


        // initialization
        $scope.filter = {};
        $scope.expenses = [];
        $scope.currentExpense = {};
        $scope.printParams = {};


        // expense CRUD
        $scope.addEditExpense = function (id) {
            if (id === undefined) {
                $scope.currentExpense = {};
            } else {
                $scope.currentExpense = _.find($scope.expenses, {id: id});
            }
            $("#edit-expense-modal").modal();
        };

        $scope.deleteExpense = function (id) {
            ExpensesService.deleteExpense(id).success(function () {
                $scope.updateExpenses();
            });
        };

        $scope.updateExpenses = function () {
            ExpensesService.getList($scope.filter).success(function (result) {
                $scope.expenses = result;
            });
        };

        $scope.saveExpense = function () {
            var service = $scope.currentExpense.id === undefined
                ? ExpensesService.createExpense : ExpensesService.updateExpense;
            service($scope.currentExpense).success(function () {
                $scope.updateExpenses();
                $scope.currentExpense = {};
                $('#edit-expense-modal').modal('hide');
                $rootScope.$broadcast('modal-reset');
            });
        };

        // filtering

        $scope.doFilter = function(){
            $scope.updateExpenses();
        };

        $scope.clearFilter = function(){
            $scope.filter={};
            $scope.filterForm.$setPristine();
            $scope.updateExpenses();
        };

        //printing

        $scope.openPrintDialog = function(){
            $scope.printParams = {};
            $("#print-expense-modal").modal();
        };

        $scope.openChartModal = function(){
            $("#chart-expense-modal").modal();
        };
        $scope.openPageToPrint = function(){
            $location.path("print/"+ $scope.printParams.dateFrom + "/" + $scope.printParams.dateTo )
        };

        $scope.logout =function(){
            $rootScope.authentificated = false;
            AuthService.logout();
            $location.path("main");
        };

        // refresh expenses for the 1st time
        $scope.updateExpenses();
        // also, get usr
        AuthService.getCurrentUser().success(function(result){
            $scope.user = result;
        });


        $scope.$watch('filter.amountMin', function (newValue, oldValue){
            if(newValue && newValue != oldValue && !/^\d*$/.test(newValue)){
                $scope.filter.amountMin = oldValue;
            }
        });

        $scope.$watch('filter.amountMax', function (newValue, oldValue){
            if(newValue && newValue != oldValue && !/^\d*$/.test(newValue)){
                $scope.filter.amountMax = oldValue;
            }
        });

        $scope.$watch('currentExpense.amount', function (newValue, oldValue){
            if(newValue && newValue != oldValue && !NUMBER_REGEX.test($scope.currentExpense.amount)) {
                $scope.currentExpense.amount = oldValue;
            }
        });

        $scope.$watch('currentExpense.time', function (newValue, oldValue){
            if(newValue && newValue != oldValue && !TIME_REGEX.test($scope.currentExpense.time)) {
                $scope.currentExpenseTimeInvalid = true;
            }else{
                $scope.currentExpenseTimeInvalid = false;
            }
        });

    });