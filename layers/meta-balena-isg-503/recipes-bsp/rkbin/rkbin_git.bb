inherit deploy

DESCRIPTION = "Rockchip binary tools (including WiFi/BT firmware)"

LICENSE = "BINARY"
LIC_FILES_CHKSUM = "file://LICENSE.TXT;md5=564e729dd65db6f65f911ce0cd340cf9"
NO_GENERIC_LICENSE[BINARY] = "LICENSE.TXT"

SRC_URI = " \
    git://github.com/RockSupport/rkbin;protocol=file;branch=main \
"
SRCREV = "de4e6ef352a8ba6b25163ed84a3e2a53303cd840"

S = "${WORKDIR}/git"

do_configure[noexec] = "1"

do_compile() {
}

do_deploy () {
    install -d ${DEPLOYDIR}/rkbin
    install -d ${DEPLOYDIR}/rkbin/tools
    install -m 755 ${S}/tools/loaderimage ${DEPLOYDIR}/rkbin/tools
    install -m 755 ${S}/rk33/px30_ddr_333MHz_v1.10.bin ${DEPLOYDIR}/rkbin
    install -m 755 ${S}/rk33/px30_miniloader_v1.15.bin ${DEPLOYDIR}/rkbin
    install -m 755 ${S}/trust.img ${DEPLOYDIR}/rkbin
}

addtask do_deploy before do_build after do_compile
