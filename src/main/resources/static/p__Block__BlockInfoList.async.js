(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([[4],{5:function(t,e){},BbBm:function(t,e,a){"use strict";a.r(e);a("g9YV");var n=a("wCAj"),i=a("MVZn"),r=a.n(i),o=a("lwsE"),c=a.n(o),l=a("W8MJ"),s=a.n(l),d=a("a1gu"),u=a.n(d),h=a("Nsbk"),p=a.n(h),g=a("7W2i"),k=a.n(g),f=a("q1tI"),m=a.n(f),y=a("Z63m"),w=a.n(y),v=10,b=function(t){function e(){var t,a;c()(this,e);for(var n=arguments.length,i=new Array(n),o=0;o<n;o++)i[o]=arguments[o];return a=u()(this,(t=p()(e)).call.apply(t,[this].concat(i))),a.state={data:[],pagination:{defaultPageSize:v},loading:!1},a.columns=[{title:"id",dataIndex:"id",key:"id",width:100},{title:"\u5361\u987f\u65f6\u957f(ms)",dataIndex:"blockTime",key:"blockTime",width:120},{title:"\u6700\u8fd1\u4e0a\u62a5",dataIndex:"insertTime",key:"insertTime",width:200},{title:"\u53d1\u751f\u6b21\u6570",dataIndex:"occurCount",key:"occurCount",width:100},{title:"\u5806\u6808",dataIndex:"stackTrace",key:"stackTrace",render:function(t,e){return m.a.createElement("a",{href:"/block/blockDetailList?id=".concat(e.id)},a.trimStackTrace(t))}}],a.handleTableChange=function(t,e,n){var i=r()({},a.state.pagination);i.current=t.current,a.setState({pagination:i}),a.fetch(r()({results:t.pageSize,page:t.current,sortField:n.field,sortOrder:n.order},e))},a.fetch=function(){var t=arguments.length>0&&void 0!==arguments[0]?arguments[0]:{};console.log("params:",t),a.setState({loading:!0}),w()({url:"http://10.113.21.105/api/getBlockInfoList",method:"get",data:r()({results:10},t),type:"json"}).then(function(t){var e=r()({},a.state.pagination);e.total=t.data.total,a.setState({loading:!1,data:t.data.data,pagination:e})})},a}return k()(e,t),s()(e,[{key:"componentDidMount",value:function(){this.fetch()}},{key:"trimStackTrace",value:function(t){var e=t.trim().split("\r\n"),a=e.length;a>5&&(e=e.slice(0,5));var n=e.join("\r\n");return a>5&&(n="".concat(n,"\r\n...")),n=n.split("\r\n").map(function(t,e){return m.a.createElement("span",{style:{display:"block"},key:e},t)}),n}},{key:"render",value:function(){return m.a.createElement(n["a"],{columns:this.columns,dataSource:this.state.data,pagination:this.state.pagination,loading:this.state.loading,onChange:this.handleTableChange})}}]),e}(f["PureComponent"]);e["default"]=b}}]);