UBOOT_KCONFIG_SUPPORT = "1"
inherit resin-u-boot

FILESEXTRAPATHS:append := ":${THISDIR}/files"

DEPENDS += "rkbin bc bc-native"

# rework meta-resin patch whose context is different now in u-boot v2019.4
SRC_URI:remove = "file://resin-specific-env-integration-kconfig.patch"

SRC_URI:append = " \
	file://0001-rocktech-Makefile.patch\
	file://0002-rocktech-isg-503-arch.patch \
	file://0003-rocktech-isg-503-evb.patch \
	file://0004-rocktech-isg-503-config.patch \
	file://0005-rocktech-isg-503-dts.patch \
	file://0006-rocktech-isg-503-part.patch \
	file://0001-Integrate-with-Balena-u-boot-environment.patch \
    file://0002-fat-Fix-sporadic-file-write-failure-when-saving-boot.patch \
    file://0001-Revert-cmd-nvedit-add-0x-prefix-for-hex-value.patch \
	file://0007-rocktech-isg-503-scripts.patch \
"



do_compile:append() {
    tools/mkimage -n px30 -T rksd -d ${DEPLOY_DIR_IMAGE}/rkbin/px30_ddr_333MHz_v1.10.bin idbloader.bin
    cat ${DEPLOY_DIR_IMAGE}/rkbin/px30_miniloader_v1.15.bin >> idbloader.bin
    ${DEPLOY_DIR_IMAGE}/rkbin/tools/loaderimage --pack --uboot ./u-boot-dtb.bin uboot.img 0x200000
}

do_compile[depends] += "rkbin:do_deploy"
