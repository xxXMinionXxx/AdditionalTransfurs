#!/usr/bin/perl

use warnings;
use strict;


#global variables
my $PACKAGE_PATH = '../../src/main/java/net/brown_bakers/bakers_transfurs/entity';
my $VERSION = '0.1';


#pre-main {{{

my $errored=0;
my $array_mode=0;
getsopt(@ARGV);


#}}}


#variables #{{{

my $template = "./templates/generic.java.template";		#template file
my $extend = "net.ltxprogrammer.changed.entity.ChangedEntity";	#which class to extend
my $config = "";

my @presets=();
my @attributes=();
my @abilities=();
my @scares=( );			#what mobs fear the variant

my $transfur_sound="";		#sound a variant makes when transfurring
my $transfur_mode="";		#default tf mode
my $mining_speed="";
#my $legs;			#amount of legs
my $entity_shape="";		#entity shape enum. Assumes changed namespace, and is a subject to change
my $use_item_mode="";
my $fly="";
my $jumps="";			#jump charges
my $vision="";			#default vision type
my $climb="";			#stiger climb
my $z_offset="";		#camera z-offset used for taurs
my $gendered="";			#this switches the script from generating 1 file, to generating 3.
my $freezing_ticks="";		#powder snow
my $breathing_mode="";
my $aqua_affinity="";
my $powder_snow_walkable="";
my $transfur_color="";
my $egg_back="";
my $egg_front="";
my @spawn_dimensions="net.minecraft.world.level.Level.OVERWORLD";

#}}}

foreach ( <STDIN> ) {
	loop_begin:

	if( /^;.*/ ) { 
		next;
	}

	if ($mode eq 'NORMAL') { #{{{

		if ( /^[A-Z_]+-=\[\h*/ ) { #if array opening {{{
$mode ='ARRAY';
			goto loop_begin; #reevaluate as array.
		} # }}}

		if ( /^TEMPLATE=(.+)/ ) { # {{{
			if(-f "templates/$1") {
				$template = $1
			}
			else {
				$errored = 1;
				print STDERR "Error: Template file $1 not found, in file $_[0]
$_";
			}

			next;
		} #}}}

		if ( $_ =~ /^EXTEND=([a-zA-Z0-9])+\h*/ ) {# {{{
			$extend = $1;
			next;
		}# }}}

		if ( /^TRANSFUR_SOUND=(.+)\h*/ ) {# unsafe {{{
			$transfur_sound = $1;
			next;
		}# }}}

		if ( /^TRANSFUR_MODE=(ABSORBING|REPLICATING|NONE)\h*/ ) { #{{{
			$transfur_mode = $1;
			next;
		} #}}}

		if ( /^MINING=(WEAK|NORMAL|STRONG)\h*/ ) { #{{{
			$mining_speed=$1;
			next;
		} #}}}

		if ( /^ENTITY_SHAPE=(ANTRO|FERAL|TAUR|NAGA|MER)\h*/ ) { #{{{
			$entity_shape = $1;
			next;
		} #}}}

		if ( /^SHOW_HOTBAR=(true|false)\h*/ ) { #{{{
			$show_hotbar = $1;
			next;
		} #}}}

		if ( /^USE_ITEM_MODE=(NORMAL|MOUTH|NONE)\h*/ ) { #{{{
			$block_breaking = $1;
			next;
		} #}}}

		if ( /^FLY=(NONE|CT|ELYTRA|BOTH)\h*/ ) {# {{{
			$fly = $1;
			next;
		}# }}}

		if ( /^JUMPS=(\d+)\h*/ ) {# {{{
			$jumps = $1;
			next;
		}# }}}

		if ( /^VISION=(NORMAL|NIGHT_VISION|BLIND|REDUCED|VAVE_VISION)\h*/ ) {# {{{
			$vision = $1;
			next;
		}# }}}

		if ( /^CLIMB=(true|false)\h*/ ) { #{{{
			$climb = $1;
			next;
		} #}}}

		if ( /^Z_OFFSET=(\d+\.\d+)\h*/ ) {# {{{
			$z_offset = $1;
			next;
		}# }}}

		if ( /^GENDERED=(true|false)\h*/ ) {# {{{
			$gendered = $1;
			next;
		}# }}}
		
		if ( /^TICKS_TO_FREEZE=(\d+)\h*/ ) {# {{{
			$freezing_ticks = $1;
			next;
		}# }}}

		if ( /^BREATH=(NORMAL|WATER|BOTH|NONE)\h*/ ) {# {{{
			$breathing_mode = $1;
			next;
		}# }}}

		if ( /^AQUA_AFFINITY=(true|false)\h*/ ){# {{{
			$aqua_affinity = $1;
			next;
		}# }}}

		if ( /^POWDER_SNOW_WALKABLE=(true|false)\h*/ ){# {{{
			$powder_snow_walkable = $1;
			next;
		}# }}}

		if ( /^TRANFUR_COLORS=(0x[0-9a-fA-F]{,6})\h*/ ) {# {{{
			$transfur_colors = $1;
			next;
		}# }}}

		if ( /^ABILITY_COLOR_1ST=(0x[0-9a-fA-F]{,6})\h*/ ) {# {{{
			$egg_back = $1;
			next;
		}# }}}

		if ( /^ABILITY_COLOR_2ND=(0x[0-9a-fA-F]{,6})\h*/ ) {# {{{
			$egg_front = $1;
			next;
		}# }}}

	 #}}}

	if ( $mode eq 'ARRAY' ) { # {{{

		if ( $_ =~ /^]\h*/ ) { #{{{
			$array = '';
			$mode = 'NORMAL';
			next;
		} # }}}

		if ( $array eq '' ) { # if we drop from normal mode, get option {{{
			$_ =~ /([A-Z]+)=\[\h*/;
			$array = $1;
			next;
		} #}}}

		if ( $array eq 'PRESETS' ) { #{{{
			$_ =~ /(.+)\h*/;
			push( @presets, $1 );
			next;
		} #}}}

		if ( $array eq 'ABILITIES' ) { #{{{
			$_ =~ /(.+)\h*/;
			push( @abilities, $1 );
			next;
		} #}}}

		if ( $array eq 'ATTRIBUTES' ) { #{{{
			$_ =~ /(.+):(.+)\h*/;
			$attributes{$1} = $2;
			next;
		} #}}}

		if ( $array eq 'SCARES' ) { #{{{
			$_ =~ /(.+)\h*/;
			push( @scares, $1 );
			next;
		} #}}}
		
		if ( $array eq 'SPAWN_DIMENSIONS' ) { #{{{
			$_ =~ /(.+)\h*/;
			push( @scares, $1 );
			next;
		} #}}}
		


		print "Unknown array definition: \"$array\", field: \"$_\"";
		$errored = 1;
		next;
	} #}}}

	$errored = 1;
	die "Internal Compiler Error - bad mode: $array";
}



#main

#feed the generator from STDIN;
#evaluate CFG
#print generated variant to STDOUT.





sub getsopt {
	if ($_ eq -h ) {
		printHelp();
		exit(0);
	}
}

sub printHelp { 
	print "
KJEntytek's303 Line Oriented Format Transfur Generator
Version $VERSION

USAGE:
./generator.sh [OPTION] [FILE]

If no file is given, the program recompiles all models inside ./variants

OPTIONS:
 -h	- Displays this message
";
} 
