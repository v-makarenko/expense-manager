/**
 * Created by VMakarenko on 2/7/15.
 */
angular.module('app')
    .controller('LeftMenuController', ['$scope', function($scope) {

    }])
    .directive('leftMenu', [function() {
        return {
            scope: {

            },
            controller: 'LeftMenuController',
            templateUrl: 'assets/html/common/directives/left-menu.html'
        };
    }]);