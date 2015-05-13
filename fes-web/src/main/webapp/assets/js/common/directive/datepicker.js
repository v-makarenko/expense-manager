'use strict';

angular.module('app')
    .directive("datepicker", function () {
        return {
            restrict: "A",
            link: function (scope, element, attrs, ngModelCtrl) {
                element.datepicker({
                        format: attrs.format || "yyyy-mm-dd",
                        language: "ru",
                        autoclose: true,
                        keyboardNavigation: attrs.navigation || true
                    });

                if(attrs.quarter){
                    element.datepicker.beforeShowDay =
                    function (date) {
                        var month = date.getMonth();
                        if (month == 0 || month == 3 || month == 7) {
                            return date.getDate()==1;
                        }else {return false}
                    }
                }

                element.bind("change", function () {
                    element.trigger('input');
                });
            }
        }
            ;
    })
;
