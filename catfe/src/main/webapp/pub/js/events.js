

const txtContainers = document.getElementsByClassName("text-container");
const imgContainers = document.getElementsByClassName("image-container");

// function windowResized() {
//     let vw = window.innerWidth;
//
//     console.log(vw);
//     if (vw < 768) {
//         imgContainers[0].style.height = '80px';
//     } else if (vw >= 768) {
//
//         imgContainers[0].style.height = txtContainers[0].clientHeight + 'px';
//         console.log(txtContainers[0].clientHeight + 'px');
//     } else {
//         imgContainers[0].classList.add("sm-size");
//     }
// }
//
// window.onresize = windowResized;

function windowResized() {
    let vw = window.innerWidth;

    console.log(vw);
    for (let i = 0; i < imgContainers.length; i++) {
        if (vw < 768) {

            imgContainers[i].style.height = '80px';

        } else if (vw >= 768) {
            imgContainers[i].style.height = txtContainers[i].clientHeight + 'px';

        }
    }
}

//Set default height
windowResized();

window.onresize = windowResized;
