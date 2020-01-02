(function ($) {
    //    "use strict";


    /*  Data Table
    -------------*/




    $('#part-data-table').DataTable({
        'lengthMenu' : [[10, 20, 50, -1], [10+'개', 20+'개', 50+'개', '전체']] ,
        'language': {
            'lengthMenu': " _MENU_ 보기",
            'zeroRecords': "조회하는 값이 없습니다.",
            'info': "현제페이지 _PAGE_ <br> 전체페이지 _PAGES_",
            'infoEmpty': "목록이 없습니다.",
            'infoFiltered': "(다시 시도 해주세요)",
            'search':	"검색 :"            	 
        },
    	
    });


    $('#bootstrap-data-table-export').DataTable({
        dom: 'lBfrtip',
        lengthMenu: [[10, 25, 50, -1], [10, 25, 50, "All"]],
        buttons: [
            'copy', '<span>복사하기</span>', 'csv', 'excel', 'pdf', 'print'
        ]
    });
	
	$('#row-select').DataTable( {
			initComplete: function () {
				this.api().columns().every( function () {
					var column = this;
					var select = $('<select class="form-control"><option value=""></option></select>')
						.appendTo( $(column.footer()).empty() )
						.on( 'change', function () {
							var val = $.fn.dataTable.util.escapeRegex(
								$(this).val()
							);
	 
							column
								.search( val ? '^'+val+'$' : '', true, false )
								.draw();
						} );
	 
					column.data().unique().sort().each( function ( d, j ) {
						select.append( '<option value="'+d+'">'+d+'</option>' )
					} );
				} );
			}
		} );






})(jQuery);