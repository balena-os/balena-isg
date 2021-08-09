inherit deploy

DESCRIPTION = "Rockchip binary rkbin"

LICENSE = "BINARY"
LIC_FILES_CHKSUM = "file://LICENSE.TXT;md5=564e729dd65db6f65f911ce0cd340cf9"
NO_GENERIC_LICENSE[BINARY] = "LICENSE.TXT"
PROVIDES = "virtual/bootloader"
SRC_URI = " \
    git://github.com/RockSupport/rkuboot;protocol=file;branch=main\
"
SRCREV = "f40ea8eb10683abea0ab7af0fe94f7b3460e2abe"

S = "${WORKDIR}/git"

do_configure[noexec] = "1"

do_compile() {
}

do_deploy () {
    touch ${DEPLOYDIR}/extra_uEnv.txt
    install ${S}/idbloader.bin ${DEPLOYDIR}
    install ${S}/uboot.img ${DEPLOYDIR}
    install -d ${DEPLOYDIR}/rkbin
    install -d ${DEPLOYDIR}/rkbin/tools
    install -m 755 ${S}/rkbin/tools/loaderimage ${DEPLOYDIR}/rkbin/tools
    install -m 755 ${S}/rkbin/px30_ddr_333MHz_v1.10.bin ${DEPLOYDIR}/rkbin
    install -m 755 ${S}/rkbin/px30_miniloader_v1.15.bin ${DEPLOYDIR}/rkbin
    install -m 755 ${S}/rkbin/trust.img ${DEPLOYDIR}/rkbin
}


addtask do_deploy before do_build after do_compile
