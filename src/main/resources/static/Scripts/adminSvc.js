/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See LICENSE in the project root for
 * license information.
 */

'use strict';
angular.module('springBootWebAppStarter')
    .factory('adminSvc', ['$http', function ($http) {
        return {
            postItem: function (item) {
                return $http.post('api/Admin/', item);
            },
            getAdminUserProfile: function (id) {
				return $http.get('api/Admin/' + id);
            },
            deleteItem: function (id) {
                return $http({
                    method: 'DELETE',
                    url: 'api/deleteAdminUserProfile/' + id
                });
			}
        };
	}
	]
);
