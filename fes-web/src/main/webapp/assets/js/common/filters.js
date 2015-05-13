/**
 * Created by VMakarenko on 2/15/15.
 */


angular.module('myFilters', []).filter('printNumber', function() {
    return function(input) {
        return Math.round(input * 100) / 100;
    };
})