(function() {
    'use strict';

    angular.module('integration.app', [
        'ngAria',
        'mobile-angular-ui',
        'mobile-angular-ui.gestures'
    ]).controller('IntegrationAppController', IntegrationAppController);

    IntegrationAppController.$inject = ['$scope', 'SharedState'];

    function IntegrationAppController($scope, SharedState) {
        // SharedState.toggle('uiSidebarLeft');
    }
})();