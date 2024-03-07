/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See LICENSE in the project root for
 * license information.
 */

'use strict';
angular.module('springBootWebAppStarter', ['ngRoute'])
    .config(['$routeProvider',  function ($routeProvider) {
        $routeProvider
        .when('/Home', {
            controller: 'homeCtrl',
            templateUrl: 'Views/Home.html',
        })
         .when('/Hello', {
			controller: 'helloCtrl',
			templateUrl: 'Views/Hello.html',
		})
         .when('/Admin', {
			controller: 'adminCtrl',
			templateUrl: 'Views/Admin.html',
        }).otherwise({redirectTo: '/Home'});
    }]);
