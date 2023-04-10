FILESEXTRAPATHS:prepend := "${THISDIR}/glibc:"

# Pi4 uses the -Os gcc flag so
# this requires fixes for the warnings
# that are treated as errors, and which only
# occurr when optimizing for space.
SRC_URI:append:isg-503 = " \
    file://Fix-build-failures-with-GCC11.patch \
"
