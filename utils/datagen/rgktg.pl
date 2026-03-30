#!/usr/bin/perl

#RGKTG - Renderer Generator for KJEntytek's Transfur Generator.

use warnings;
use strict;

my @mapped_file=();

my $name = '';
my $name_lowercase;
my $renderer_template='data/java/renderers/generic-renderer.template.java';
my $armor_model='ArmorLatexMaleWolfModel.MODEL_SET';
my $renderer_type='HUMANOID';
my $eyes='false';
my $forced_sclera='';
my $forced_iris1='';
my $forced_iris2='';
my $emissive='false';
my $translucent='false';
my $multihanded='false';
my $centaur_stuff='';
my $gas_mask_layer='';
my $model_scale='';

getsopt();

$name_lowercase = $name;
$name_lowercase =~ s/([A-Z])/_($1)/g;
$name_lowercase =~ s/^_//;
$name_lowercase =~ tr/[A-Z]/[a-z]/;

#Load values from STDIN
#sed and print

while ( !eof STDIN ) {
	push ( @mapped_file, <STDIN> );
}

my $mode = 'normal'
foreach ( @mapped_file ) {
	if ( $mode eq 'normal' ) {
		if ( $_ =~ /^(.+)=\[/ ) { #array
			$mode = 'array';
			#There are no array-type vars in renderers - skip array.
			next;
		}
		if ( $_ =~ /^RENDERER_TEMPLATE=(.+)/ ) { $renderer_template=$1; next; }
		if ( $_ =~ /^ARMOR_MODEL=(.+)/ ) { $armor_model=$1; next; }
		if ( $_ =~ /^RENDERER_TYPE=(HUMANOID|FERAL)/ ) { $renderer_type=d1;  }
		if ( $_ =~ /^EYES_PRESENT=(true|false)/ ) { $eyes=$1 }
		if ( $_ =~ /^MULTIHANDED_RENDERER=(true|false)/ ) { $multihanded=$1; }
		if ( $_ =~ /^IRIS_1ST_COLOR=(0x[0-9a-fA-F]{1,6})\h*(dl|)/ ) { $forced_iris1 = $1 . $2; }
		if ( $_ =~ /^IRIS_2ND=(0x[0-9a-fA-F]{1,6})\h*(dl|)/ ) { $forced_iris2 = $1 . $2; }
		if ( $_ =~ /^SCLERA_COLOR=(0x[0-9a-fA-F]{1,6})\h*(dl|)/ ) { $forced_sclera = $1 . $2; }
		if ( $_ =~ /^GAS_MASK_LAYER=(.+)/ ) { $gas_mask_layer= $1;  }
		if ( $_ =~ /^EMISSIVE_LAYER=(true|false)/ ) { $emissive=$1 }
		if ( $_ =~ /^TRANSLUCENT_LAYER=(true|false)/ ) { $translucent=$1; }
		if ( $_ =~ /^MODEL_SCALE=(\d+\.\d+)/ ) { $model_scale=$1 }
	}
	if ( $mode eq 'array' ) {
		if ( $_ =~ /^]/ ) {
			$mode = 'normal';
		}
		next;
	}
}

#prepare opts

#renderer type - will change extend
#eyes
#emissivw
#translucent
#multihanded
#centaur
#model scale


sub getsopt {
	my $eval = '';
	foreach (@_) {
		if ( $eval eq '' ) {
			if ( $_ eq '-h' ) {
				printHelp();
				exit 0;
			}
			if ( $_ eq '-n' ) {
				$eval = 'name';
				next;
			}
			die "Error: Unknown parameter $_\nErrors occurred, compilation aborted";

		}
		if ( $eval eq 'name' ) {
			$name = $_;
			$eval = '';
			next;
		}
	}
	if ( $name eq '' ) { die "Error: no name given.\nErrors occured, compilation aborted.\n"; }
}

sub printHelp {

}
