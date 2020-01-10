( function ( $ ) {
    "use strict";
    // single bar chart
    var ctx = document.getElementById( "singelBarChart" );
    var aa = document.getElementById("monday");
    console.log(aa.value);
    var monday = aa.value;
    
    ctx.height = 150;
    var myChart = new Chart( ctx, {
        type: 'bar',
        data: {
            labels: [ "월요일", "화요일", "수요일", "목요일", "금요일", "토요일"],
            datasets: [
                {
                    label: "요일별 판매건수",
                    data: [ monday , 50, 75, 100, 56, 55, 60 ],
                    borderColor: "rgba(0, 194, 146, 0.9)",
                    borderWidth: "0",
                    backgroundColor: "rgba(0, 194, 146, 0.5)"
                            }
                        ]
        },
        options: {
            scales: {
                yAxes: [ {
                    ticks: {
                        beginAtZero: true
                    }
                                } ]
            }
        }
    } );

} )( jQuery );