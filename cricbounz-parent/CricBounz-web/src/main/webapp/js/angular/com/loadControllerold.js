

var dbApp = angular.module('dashboardModule', ['infinite-scroll']);

angular.module("CricApp", ["dashboardModule", "teamModule", "groundModule", "tournamentModule", "file-model", "userModule","jkuri.timepicker"]);



function getCookie(name) {
    var value = "; " + document.cookie;
    var parts = value.split("; " + name + "=");
    if (parts.length == 2)
    {
        return parts.pop().split(";").shift();
    }
}
dbApp.directive('validNumber', function() {
  return {
    require: '?ngModel',
    link: function(scope, element, attrs, ngModelCtrl) {
      if(!ngModelCtrl) {
        return; 
      }

      ngModelCtrl.$parsers.push(function(val) {
        if (angular.isUndefined(val)) {
            var val = '';
        }
        var clean = val.replace( /[^0-9]+/g, '');
        if (val !== clean) {
          ngModelCtrl.$setViewValue(clean);
          ngModelCtrl.$render();
        }
        return clean;
      });

      element.bind('keypress', function(event) {
        if(event.keyCode === 32) {
          event.preventDefault();
        }
      });
    }
  };
});
dbApp.controller('TodoCtrl', function ($scope, $http) {
    $http.get('response/activity.jsp')
            .then(function (res) {
                $scope.activities = res.data;
            });
    /*$scope.loadContentArea = function($scope, $http){
     
     var myEl = angular.element( document.querySelector( '#content' ) );
     myEl.html('<p>test</p>')      
     }*/
});

dbApp.controller('loadCity', function ($scope, $http) {
    $http.get('json/cityList.json')
            .then(function (res) {
                $scope.cityList = res.data;
                console.log(angular.toJson($scope.cityList));
            });
});
dbApp.controller('loadArea', function ($scope, $http) {
    $http.get('json/areaList.json')
            .then(function (res) {
                $scope.areaList = res.data;
                console.log(angular.toJson($scope.areaList));
            });
});
dbApp.controller('loadGrounds', function ($scope, $http) {
    $http.get('json/grounds.json')
            .then(function (res) {
                $scope.grounds = res.data;
                console.log(angular.toJson($scope.grounds));
            });
});




// var to use as a flag to prevent http requests from happening when one is already occuring
var infinite_loading = false;

/*
 * Create custom factory for the dynamic loading
 */
dbApp.factory('PostImages', function ($http) {
    /*
     * load
     * Load in the press releases
     */
    var load = function (full_url, last_loaded_url) {
        infinite_loading = true;
        return $http({method: "GET", url: full_url}).then(function (result) {
            return result.data;
        });
    };

    return {load: load};
});

/**
 * PressReleaseController
 */
dbApp.controller('LazyLoadController', ['$scope', '$http', 'PostImages', function ($scope, $http, PostImages) {
        // establish vars
        $scope.postedData = [];
        $scope.limit = 5;
        $scope.offset = 0;
        $scope.more_items = true; // flag to see if we hit the end of the json feed

        /**
         * loadMore
         * Adjust the offset using the limit to add X number of
         * items to the list
         */
        $scope.loadItems = function () {
            // make sure there are more items to load
            if ($scope.more_items == true && infinite_loading == false) {
                var url = 'response/UserPosts.jsp?limit=' + $scope.limit + '&offset=' + $scope.offset;

                // load the press releases
                var getPostImages = PostImages.load(url, $scope.last_loaded_url);

                // this is only run after $http completes
                getPostImages.then(function (result) {
                    // we finished loading, set the flag back
                    infinite_loading = false;

                    // check if there were any news items in the latest feed
                    if (result.news.length == 0) {
                        $scope.more_items = false;
                    } else {
                        // result news
                        $scope.postedData = $scope.postedData.concat(result.news);
                    }

                    // increment the offset for next time loadMore() is called
                    $scope.offset = $scope.limit + $scope.offset;


                    // update the last loaded url
                    $scope.last_loaded_url = url;
                });
            }
        }
    }]);

/**
 * ng-infinite-scroll - v1.2.0 - 2014-12-02
 */
var mod;
mod = angular.module("infinite-scroll", []), mod.value("THROTTLE_MILLISECONDS", null), mod.directive("infiniteScroll", ["$rootScope", "$window", "$interval", "THROTTLE_MILLISECONDS", function (a, b, c, d) {
        return {scope: {infiniteScroll: "&", infiniteScrollContainer: "=", infiniteScrollDistance: "=", infiniteScrollDisabled: "=", infiniteScrollUseDocumentBottom: "="}, link: function (e, f, g) {
                var h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x;
                return x = angular.element(b), t = null, u = null, i = null, j = null, q = !0, w = !1, p = function (a) {
                    return a = a[0] || a, isNaN(a.offsetHeight) ? a.document.documentElement.clientHeight : a.offsetHeight
                }, r = function (a) {
                    return a[0].getBoundingClientRect && !a.css("none") ? a[0].getBoundingClientRect().top + s(a) : void 0
                }, s = function (a) {
                    return a = a[0] || a, isNaN(window.pageYOffset) ? a.document.documentElement.scrollTop : a.ownerDocument.defaultView.pageYOffset
                }, o = function () {
                    var b, c, d, g, h;
                    return j === x ? (b = p(j) + s(j[0].document.documentElement), d = r(f) + p(f)) : (b = p(j), c = 0, void 0 !== r(j) && (c = r(j)), d = r(f) - c + p(f)), w && (d = p((f[0].ownerDocument || f[0].document).documentElement)), g = d - b, h = g <= p(j) * t + 1, h ? (i = !0, u ? e.$$phase || a.$$phase ? e.infiniteScroll() : e.$apply(e.infiniteScroll) : void 0) : i = !1
                }, v = function (a, b) {
                    var d, e, f;
                    return f = null, e = 0, d = function () {
                        var b;
                        return e = (new Date).getTime(), c.cancel(f), f = null, a.call(), b = null
                    }, function () {
                        var g, h;
                        return g = (new Date).getTime(), h = b - (g - e), 0 >= h ? (clearTimeout(f), c.cancel(f), f = null, e = g, a.call()) : f ? void 0 : f = c(d, h, 1)
                    }
                }, null != d && (o = v(o, d)), e.$on("$destroy", function () {
                    return j.unbind("scroll", o)
                }), m = function (a) {
                    return t = parseFloat(a) || 0
                }, e.$watch("infiniteScrollDistance", m), m(e.infiniteScrollDistance), l = function (a) {
                    return u = !a, u && i ? (i = !1, o()) : void 0
                }, e.$watch("infiniteScrollDisabled", l), l(e.infiniteScrollDisabled), n = function (a) {
                    return w = a
                }, e.$watch("infiniteScrollUseDocumentBottom", n), n(e.infiniteScrollUseDocumentBottom), h = function (a) {
                    return null != j && j.unbind("scroll", o), j = a, null != a ? j.bind("scroll", o) : void 0
                }, h(x), k = function (a) {
                    if (null != a && 0 !== a.length) {
                        if (a instanceof HTMLElement ? a = angular.element(a) : "function" == typeof a.append ? a = angular.element(a[a.length - 1]) : "string" == typeof a && (a = angular.element(document.querySelector(a))), null != a)
                            return h(a);
                        throw new Exception("invalid infinite-scroll-container attribute.")
                    }
                }, e.$watch("infiniteScrollContainer", k), k(e.infiniteScrollContainer || []), null != g.infiniteScrollParent && h(angular.element(f.parent())), null != g.infiniteScrollImmediateCheck && (q = e.$eval(g.infiniteScrollImmediateCheck)), c(function () {
                    return q ? o() : void 0
                }, 0, 1)
            }}
    }]);


