<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>

    <link href="assets/css/lib/bootstrap/bootstrap.css" rel="stylesheet">
    <link href="assets/css/lib/bootstrap-datetimepicker/bootstrap-datetimepicker.min.css" rel="stylesheet">
    <link href="assets/css/lib/datetimepicker.css"  rel="stylesheet" >
    <link href="assets/css/styles.css" rel="stylesheet">
    <link href="assets/js/lib/angular-tree-ui/angular-ui-tree.js"/>

    <script src="assets/js/lib/moment/moment.js"></script>
    <script src="assets/js/lib/jquery/jquery-1.11.2.js"></script>
    <script src="assets/js/lib/jquery-ui/jquery-ui.js"></script>
    <script src="assets/js/lib/angular/angular.min.js"></script>
    <script src="assets/js/lib/angular/angular-route.min.js"></script>
    <script src="assets/js/lib/angular-ui/ui-bootstrap-0.13.0.js"></script>
    <script src="assets/js/lib/angular-ui/ui-bootstrap-tpls-0.13.0.js"></script>
    <script src="assets/js/lib/angular-tree-ui/angular-ui-tree.js"></script>
    <script src="assets/js/lib/bootstrap/bootstrap.js"></script>
    <script src="assets/js/lib/underscore/underscore.js"></script>
    <script src="assets/js/lib/charts/Chart.js"></script>
    <script src="assets/js/lib/charts/angular-chart.js"></script>

    <script src="assets/js/lib/bootstrap-datepicker/bootstrap-datepicker.js"></script>
    <script src="assets/js/lib/bootstrap-datetimepicker/bootstrap-datetimepicker.js"></script>
    <script src="assets/js/lib/bootstrap-datetimepicker/moment.js"></script>
    <script src="assets/js/lib/datetimepicker/datetimepicker.js"></script>
    <!-- angular user js -->
    <script src="assets/js/common/filters.js"></script>
    <script src="assets/js/expenses/app.js"></script>

    <script src="assets/js/expenses/controllers/expenses-list-controller.js"></script>
    <script src="assets/js/expenses/controllers/reg-controller.js"></script>
    <script src="assets/js/expenses/controllers/auth-controller.js"></script>
    <script src="assets/js/expenses/controllers/print-controller.js"></script>
    <script src="assets/js/expenses/controllers/auth-test-controller.js"></script>
    <script src="assets/js/expenses/controllers/main-page-controller.js"></script>
    <script src="assets/js/expenses/controllers/login-controller.js"></script>
    <script src="assets/js/expenses/controllers/registration-controller.js"></script>
    <script src="assets/js/expenses/controllers/modal-controller.js"></script>
    <script src="assets/js/expenses/controllers/chart-controller.js"></script>
    <script src="assets/js/expenses/controllers/valuta-reference-edit-controller.js"></script>
    <script src="assets/js/expenses/controllers/valuta-reference-modal-controller.js"></script>
    <script src="assets/js/expenses/controllers/account-reference-edit-controller.js"></script>

    <script src="assets/js/expenses/services/expenses-service.js"></script>
    <script src="assets/js/common/services/auth-service.js"></script>
    <script src="assets/js/expenses/services/user-service.js"></script>
    <script src="assets/js/expenses/services/chart-service.js"></script>
    <script src="assets/js/expenses/services/valuta-reference-service.js"></script>
    <script src="assets/js/expenses/services/account-reference-service.js"></script>

    <script src="assets/js/expenses/directive/expense-unit.js"></script>
    <script src="assets/js/common/directive/datepicker.js"></script>
    <script src="assets/js/common/directive/left-menu.js"></script>

</head>
<body ng-app="app">
<div class="container-fluid">
    <div class="row">
    <div class="col-lg-3" left-menu></div>
<div class="col-lg-9" ng-view>
</div>
</div>
</div>

</body>
</html>