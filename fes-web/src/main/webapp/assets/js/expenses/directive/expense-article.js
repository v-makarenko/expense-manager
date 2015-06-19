/**
 * Created by VMakarenko on 2/7/15.
 */
angular.module('app')
    .controller('ExpenseArticleController', ['$scope', function($scope) {
    }])
    .directive('expenseArticle', [function() {
        return {
            scope: {
                categoriesList:"=?categoriesList"
            },
            controller: 'ExpenseArticleController',
            templateUrl: 'assets/html/expenses/directives/expense-article.html'
        };
    }]);