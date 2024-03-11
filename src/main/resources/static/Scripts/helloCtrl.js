/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See LICENSE in the project root for
 * license information.
 */

'use strict';
angular.module('springBootWebAppStarter')
    .controller('helloCtrl', ['$scope', '$location', 'helloSvc', function ($scope, $location, helloSvc) {
        $scope.error = '';
        $scope.loadingMessage = '';
        $scope.item = null;        
        
        $scope.newHelloUserName = '';
        $scope.newHelloUserEmailAddress = '';
        $scope.newIsAdmin = false;

        $scope.add = function () {
			helloSvc.postItem({
				'userName': $scope.newHelloUserName,
				'preferredUserName': $scope.newHelloUserEmailAddress,
				'isAdmin': $scope.newIsAdmin,
			}).success(function (results) {
				$scope.populate();
				$scope.loadingMessage = results;
			}).error(function (err) {
				$scope.error = err;
				$scope.loadingMessage = '';
			})
        };
        
        $scope.populate = function () {
	        $scope.error = '';
	        $scope.newHelloUserName = '';
	        $scope.newHelloUserEmailAddress = '';
	        $scope.loadingMessage = '';
	        $scope.item = null;
        };

    }]);