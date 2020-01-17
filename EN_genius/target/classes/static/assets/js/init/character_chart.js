( function ( $ ) {
    "use strict";

 

    //radar chart
    var ctx = document.getElementById( "radarChart" );
    ctx.height = 100;
    var myChart = new Chart( ctx, {
        type: 'radar',
        data: {
            labels: [ "java", "javascript", "HTML5", "CSS3", "MySql" ],
            datasets: [
                {
                    label: "technique",
                    data: [ 85,75,75,65,80 ],
                    borderColor: "red",
                    borderWidth: "2",
                    backgroundColor: "rgba(25, 111, 200, 0.7)"
                            }
//                ,
//                {
//                    label: "My Second dataset",
//                    data: [ 28, 5, 55, 19, 63, 27, 68 ],
//                    borderColor: "rgba(0, 194, 146, 0.7", rgba(0, 194, 146, 0.4)
//                    borderWidth: "1", rgba(0, 194, 146, 0.6)
//                    backgroundColor: "rgba(0, 194, 146, 0.5)"
//                            }
                        ]
        },
        options: {
            legend: {
                position: 'top'
            },
            scale: {
                ticks: {
                    beginAtZero: true
                }
            }
        }
    });




} )( jQuery );