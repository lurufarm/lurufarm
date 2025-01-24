
// Navigation script

const $navi = document.querySelector(".navigation");
const naviUl = $navi.children[0];
const naviLi = naviUl.children;
let windowHeight = window.innerHeight;

function changeNaviClassName()
{
    let scrollY = window.pageYOffset;

    if (scrollY >= 0 && scrollY < 650)
    {
        naviLi[0].querySelector('a').className = "active";
        naviLi[1].querySelector('a').className = "inactive";
        naviLi[2].querySelector('a').className = "inactive";
        naviLi[3].querySelector('a').className = "inactive";
    }
    else if (scrollY >= 650 && scrollY < 1300)
    {
        naviLi[0].querySelector('a').className = "inactive";
        naviLi[1].querySelector('a').className = "active";
        naviLi[2].querySelector('a').className = "inactive";
        naviLi[3].querySelector('a').className = "inactive";
    }
    else if (scrollY >= 1300 && scrollY < 1950)
    {
        naviLi[0].querySelector('a').className = "inactive";
        naviLi[1].querySelector('a').className = "inactive";
        naviLi[2].querySelector('a').className = "active";
        naviLi[3].querySelector('a').className = "inactive";
    }
    else
    {
        naviLi[0].querySelector('a').className = "inactive";
        naviLi[1].querySelector('a').className = "inactive";
        naviLi[2].querySelector('a').className = "inactive";
        naviLi[3].querySelector('a').className = "active";
    }

}

// Project script

const $indicators = document.querySelectorAll(".indicator");
const indicator1 = $indicators[0];
const indicator2 = $indicators[1];
const indicator3 = $indicators[2];

let windowWidth = window.innerWidth;

indicator1.classList.add("active");
indicator1.onclick = function() { changePage(this) };
indicator2.onclick = function() { changePage(this) };
indicator3.onclick = function() { changePage(this) };

function changePage(obj)
{
    $indicators.forEach(ind => ind.classList.remove("active"));
    obj.classList.add("active");

    const slider = document.querySelector('.projectSlider');
    const slideWidth = 912 + 500;  // 한 슬라이드 너비 + 마진

    if (obj == indicator1)
        slider.style.transform = `translateX(0)`;  // 첫 번째 슬라이드라 이동 없음
    else if (obj == indicator2)
         slider.style.transform = `translateX(-${slideWidth}px)`;  // 한 슬라이드 너비만큼 이동
    else
         slider.style.transform = `translateX(-${slideWidth * 2}px)`;  // 두 슬라이드 너비만큼 이동
    }

