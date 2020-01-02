( function ( $ ) {
    "use strict";
    // single bar chart
    var ctx = document.getElementById( "singelBarChart" );
    var aa = document.getElementById("test");
    console.log(aa.value);
    var test = aa.value;
    ctx.height = 150;
    var myChart = new Chart( ctx, {
        type: 'bar',
        data: {
            labels: [ "월요일", "화요일", "수요일", "목요일", "금요일", "토요일"],
            datasets: [
                {
                    label: "요일별 판매건수",
                    data: [ test , 50, 75, 80, 56, 55, 60 ],
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