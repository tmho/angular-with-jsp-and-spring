<div class="panel-group" id="companies-accordion" ng-controller="companiesListController">
    <div class="panel panel-default" ng-repeat="company in state.companies | orderBy: 'name'">
        <div class="panel-heading">
            <h4 class="panel-title">
                <a data-toggle="collapse" data-parent="#companies-accordion" href="#companies-{{company.id}}"
                   ng-click="findManagers(company.id)">
                    {{company.name}}
                </a>
            </h4>
        </div>
        <div id="companies-{{company.id}}" class="panel-collapse collapse">
            <div class="panel-body">
                <div class="panel-group" id="managers-accordion-{{company.id}}">
                    <div class="panel panel-default" ng-repeat="manager in state.managers | orderBy: 'surname'">
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <a data-toggle="collapse" data-parent="#managers-accordion-{{company.id}}"
                                   href="#managers-{{company.id}}-{{manager.id}}">
                                    {{manager.surname}}, {{manager.firstname}}
                                </a>
                            </h4>
                        </div>
                        <div id="managers-{{company.id}}-{{manager.id}}" class="panel-collapse collapse">
                            <div class="panel-body">
                                Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad
                                squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck
                                quinoa
                                nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid
                                single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft
                                beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher
                                vice
                                lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you
                                probably haven't heard of them accusamus labore sustainable VHS.
                            </div>
                        </div>
                    </div>
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <a data-toggle="modal" data-target="#addManagerModal" href="#">+</a>
                            </h4>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="panel panel-default">
        <div class="panel-heading">
            <h4 class="panel-title">
                <a data-toggle="modal" data-target="#addCompanyModal" href="#">+</a>
            </h4>
        </div>
    </div>
</div>

<!-- Modal -->
<div class="modal fade" id="addCompanyModal" ng-controller="addCompanyModalController">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">Add a new company</h4>
            </div>
            <div class="modal-body">
                    <form class="navbar-form navbar-left" role="search">
                        <div class="form-group">
                            <input type="text" class="form-control" label="hello">
                            <input type="text" class="form-control">
                            <input type="text" class="form-control">
                            <input type="text" class="form-control">
                            <input type="text" class="form-control">
                            <input type="text" class="form-control">
                        </div>
                        <button type="submit" class="btn btn-default">Submit</button>
                    </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary" ng-click="createCompany()">Save changes</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>
<!-- /.modal -->

<!-- Modal -->
<div class="modal fade" id="addManagerModal" ng-controller="addManagerModalController">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">Add a new manager</h4>
            </div>
            <div class="modal-body">
                ...
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary" ng-click="save()">Save changes</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>
<!-- /.modal -->
