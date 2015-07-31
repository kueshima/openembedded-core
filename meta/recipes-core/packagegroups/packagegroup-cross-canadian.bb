SUMMARY = "Host SDK package for cross canadian toolchain"
PN = "packagegroup-cross-canadian-${MACHINE}"
LICENSE = "MIT"

# Save TRANSLATED_TARGET_ARCH before allarch tramples it
TRANSLATED_TARGET_ARCH = "${@d.getVar('TUNE_ARCH', True).replace('_', '-')}"

inherit cross-canadian packagegroup

PACKAGEGROUP_DISABLE_COMPLEMENTARY = "1"

# Use indirection to stop these being expanded prematurely
BINUTILS = "binutils-cross-canadian-${TRANSLATED_TARGET_ARCH}"
GCC = "gcc-cross-canadian-${TRANSLATED_TARGET_ARCH}"
GDB = "gdb-cross-canadian-${TRANSLATED_TARGET_ARCH}"

RDEPENDS_${PN} = "\
    ${@all_multilib_tune_values(d, 'BINUTILS')} \
    ${@all_multilib_tune_values(d, 'GCC')} \
    ${@all_multilib_tune_values(d, 'GDB')} \
    meta-environment-${MACHINE} \
    "
