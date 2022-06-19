angular.module('front', []).controller('appController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/market';

    $scope.loadProducts= function () {
        $http.get(contextPath + '/products')
            .then(function (response) {
                $scope.Product = response.data ;
            });
    }


     $scope.deleteScore = function (productId) {
        $http.get(contextPath + '/products/delete/' + productId)
            .then(function (response) {
                $scope.loadProducts();
            });
    }


    $scope.loadProducts(1);
});

