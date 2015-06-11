/**
 * Created by VMakarenko on 2/7/15.
 */

angular.module("app")
    .service("AccountReferenceService", ['$http',
function AccountReferenceService($http ) {
    var url ="api/references/accounts";

    this.getAll = function(filter){
        return $http.post(url + "/all", filter);
    };

    this.insert = function(account){
        return $http.post(url, account);
    };

    this.update = function(account){
        return $http.put(url, account);
    };

    this.delete = function(id){
        return $http.delete(url + "?id=" + id);
    };

    }
]);

