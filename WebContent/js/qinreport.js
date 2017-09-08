var report = {
	init: function(){
		$("#checkAnswer").click(function(){
			location.href = ctx + "/testprocess/report/resultIndex?testId=" + testId + "&paperId=" + paperId + "&type=" + acType + "&ext=roleType@" + roleType;
		});
		
		report.structureRadarMap();
	},
	structureRadarMap: function(){
		var myChart = echarts.init(document.getElementById('radarMapId'));
		
		// 指定图表的配置项和数据
        var option = report.getOption();

        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
        
        try{
        	var imgDataUri = myChart.getDataURL();
        	$("#imgRadarMapId").show();
            document.getElementById("radarMapImgId").src = imgDataUri;
        }catch(e){
        	$("#radarMapId").show();
        }
	},
	getOption: function(){
		option = {
		    title: {
		        text: ''
		    },
		    legend: {
		        x: 'center'
		    },
		    radar: [
		        {
		            indicator: eval(pointData),
		            center: ['53%','50%'],
		            radius: 80,
		            name: {
		                textStyle: {
		                    color:'#000'
		                }
		            }
		        }
		    ],
		    series: [
		        {
		            type: 'radar',
		             tooltip: {
		                trigger: 'item'
		            },
		            itemStyle: {normal: {areaStyle: {type: 'default'}, color: '#45c7c9', cursor:'move'}},
		            data: [
		                {
		                    value: eval(pointCorrectData),
		                    name: '考点'
		                }
		            ]
		        }
		    ]
		};
		
		return option;
	},
	qReportContent: function(){
		AppUtils.showMask('body');
		var data = {
			"testId": testId,
			"paperId": paperId
		};
		
		AppUtils.doPost(ctx + '/otstest/report/queryReportContent', data, function(res) {
			$('#reportContent').html(res.gridHTML);
			
			$("#checkAnswer").click(function(){
				report.qReportDetail();
			});
			
			AppUtils.hideMask();
		});
	},
	qReportDetail: function(){
		AppUtils.showMask('body');
		var data = {
				"testId": testId,
				"paperId": paperId
		};
			
		AppUtils.doPost(ctx + '/otstest/report/queryReportDetail', data, function(res) {
			$('#reportContent').html(res.gridHTML);
			
			AppUtils.hideMask();
		});
	}
}