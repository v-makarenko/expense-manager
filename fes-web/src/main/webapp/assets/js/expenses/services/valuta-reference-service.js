/**
 * Created by VMakarenko on 2/7/15.
 */

angular.module("app")
    .service("ValutaReferenceService", ['$http',
function ValutaReferenceService($http ) {
    var url ="api/private/references/valuta";

    this.getAll = function(filter){
        return $http.post(url + "/all", filter);
    };

    this.insert = function(valuta){
        return $http.post(url, valuta);
    };

    this.update = function(valuta){
        return $http.put(url, valuta);
    };

    this.delete = function(id){
        return $http.delete(url + "?id=" + id);
    };

    }
]);

