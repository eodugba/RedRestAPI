angular.module('visits', [])
.controller('cities', function($scope, $http) {
    var url = "http://localhost:8080/user/"+sessionStorage.UserID +"/visits";
    $http.get(url).
        then(function(response) {
            $scope.userCitiesVisited = response.data;
        });
        
});