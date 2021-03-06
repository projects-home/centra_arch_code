(function () {
	seajs.config({
		base: STESTER_ROOT+"/resources/spm_modules",
		alias:{
			'jquery' :"jquery/1.9.1/jquery"
		},
		paths: {
			"centaurus":STESTER_ROOT+"/resources/centaurus"
		}
	});
	
	seajs.use(["bootstrap/dist/css/bootstrap.css",
	           "centaurus/css/libs/nanoscroller.css",
	           "centaurus/css/libs/font-awesome.css",
	           "centaurus/css/compiled/theme_styles.css",
	           "centaurus/css/libs/fullcalendar.css",
	           "centaurus/css/libs/morris.css",
	           "centaurus/css/libs/daterangepicker.css",
	           "centaurus/css/libs/timeline.css",
	           "centaurus/css/compiled/calendar.css",
	           "centaurus/css/libs/dialog.css",
	           "centaurus/css/libs/select.css",
	           "centaurus/css/libs/poptip.css",
	           "centaurus/css/libs/dialog.css",
		       "jsoneditor/5.1.5/jsoneditor.min.css",
			   "arale-validator/0.10.2/alice.components.ui-button-orange-1.3-full.css",
			   "arale-validator/0.10.2/alice.components.ui-form-1.0-src.css"
	]);
})();