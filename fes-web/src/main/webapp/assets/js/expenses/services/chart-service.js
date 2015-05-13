/**
 * Created by VMakarenko on 3/8/15.
 */


angular.module("app")
    .service("ChartService", ['$http',
        function ChartService($http ) {
            var url ="api/chartData";
            this.getData = function(typeId){
                return $http.get(url + "?for=" + typeId);
            };

        }
    ]);

