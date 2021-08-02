inherit deploy

DESCRIPTION = "Rockchip uboot bin"

DEPENDS_append = " bison-native rkbin "

LICENSE = "BINARY"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=30503fd321432fc713238f582193b78e"
NO_GENERIC_LICENSE[BINARY] = "LICENSE.TXT"
#require recipes-bsp/u-boot/u-boot.inc
PROVIDES = "virtual/bootloader"
FILESEXTRAPATHS_append := ":${THISDIR}/files"
SRC_URI = " \
	git://github.com/u-boot/u-boot \
	file://idbloader.bin  \
        file://uboot.img  \
"
SRCREV_isg-503  = "v2019.10"

S = "${WORKDIR}/git"

do_configure[noexec] = "1"

do_compile () {
	cp ${WORKDIR}/idbloader.bin .
	cp ${WORKDIR}/uboot.img .
}

do_deploy () {
	touch ${DEPLOYDIR}/extra_uEnv.txt
	install ${S}/idbloader.bin ${DEPLOYDIR}
	install ${S}/uboot.img ${DEPLOYDIR}
}
addtask deploy before do_build after do_compile
