DESCRIPTION = "Rocktech ISG503 U-Boot"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=a2c678cfd4a4d97135585cad908541c6"
require u-boot-rockchip.inc
DEPENDS += "bison-native"


SRC_URI = " \
    git://github.com/rockchip-linux/u-boot.git;protocol=https;branch=next-dev \
"

SRCREV = "65c356141d79b7380748344d558b3871061c907a"

S = "${WORKDIR}/git"

do_install:append() {
    install -d ${D}/boot
    install -c -m 0644 ${B}/idbloader.bin ${B}/uboot.img ${D}/boot
}

do_deploy:append() {
    install ${B}/idbloader.bin ${DEPLOYDIR}
    install ${B}/uboot.img ${DEPLOYDIR}
}
