UBOOT_KCONFIG_SUPPORT = "1"
inherit resin-u-boot

FILESEXTRAPATHS_append := ":${THISDIR}/files"

SRC_URI_append = " \
    file://0001-Integrate-with-Balena-u-boot-environment.patch \
    file://0006-u-boot-Enable-SETEXPR.patch \
"
