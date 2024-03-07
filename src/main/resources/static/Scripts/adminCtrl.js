/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See LICENSE in the project root for
 * license information.
 */

'use strict';
angular.module('springBootWebAppStarter')
    .controller('adminCtrl', ['$scope', 'adminSvc', function ($scope, adminSvc) {
        $scope.error = '';
        $scope.loadingMessage = '';
        $scope.item = null;
        
        $scope.adminUserName = null;
        $scope.adminUserEmailAddress = null;
        $scope.isAdmin = true;

        $scope.add = function () {
			adminSvc.postItem({
				'username': $scope.helloUserName,
				'preferredUserName': $scope.helloUserEmailAddress,
				'isAdmin': $scope.isAdmin,
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
	        $scope.adminUserName = '';
	        $scope.adminUserEmailAddress = '';
	        $scope.loadingMessage = '';
	        $scope.item = null;
        };

    }]);
